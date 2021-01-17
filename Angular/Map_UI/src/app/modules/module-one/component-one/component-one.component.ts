import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { HikingTrail } from '../../../shared/models/hiking-trail.model';
import { Park } from '../../../shared/models/park.model';
import { TouristAttraction } from '../../../shared/models/tourist-attraction.model';
import { TouristRoute } from '../../../shared/models/tourist-route.model';
import { HttpService } from '../../../core/http/http.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { loadModules } from 'esri-loader';
import { Extent } from 'esri/geometry';
import { identifierModuleUrl } from '@angular/compiler';
import { PictureMarkerSymbol, WebStyleSymbol } from 'esri/symbols';

@Component({
  selector: 'app-component-one',
  templateUrl: './component-one.component.html',
  styleUrls: ['./component-one.component.scss'],
})
export class ComponentOneComponent implements OnInit {
  @ViewChild('mapView', { static: true })
  private readonly mapViewElement: ElementRef;
  searchForm: FormGroup;
  private mapView: __esri.MapView;
  hikingTrails: HikingTrail[];
  parks: Park[];
  touristAttractions: TouristAttraction[];
  touristRoutes: TouristRoute[];
  hikingTrailFields: any;
  hikingTrailPopupHtml =
    '<span>Length: {length} kilometers</span><br>\
  <span>Duration: {duration} minutes</span><br>\
  <span>Difficulty: {dificulty}</span>';

  map: any;
  /*
  const location = new Point({
                  latitude: dmsDD(latitude, latitudeDirection),
                  longitude: dmsDD(longitude, longitudeDirection)
                });

                new Graphic({
                    geometry: location,
                    attributes: {
                      url: url,
                      OBJECTID: id
                    }
                  })
  */

  constructor(
    public dialog: MatDialog,
    public service: HttpService,
    public fb: FormBuilder
  ) {
    // This function to load Dojo's require the classes listed in the array modules
    loadModules([
      'esri/Map',
      'esri/views/MapView',
      'esri/layers/MapImageLayer',
    ]).then(
      ([Map, MapView, MapImageLayer]: [
        __esri.MapConstructor,
        __esri.MapViewConstructor,
        __esri.MapImageLayerConstructor
      ]) => {
        // set default map properties
        //
        const mapProperties = {
          basemap: 'topo-vector',
        };
        // create map by default properties
        const map = new Map(mapProperties);
        this.map = map;
        // set default map view properties
        // container - element in html-template for locate map
        // zoom - default zoom parameter, value from 1 to 18
        const mapViewProperties = {
          container: this.mapViewElement.nativeElement,
          center: [16.367, 48.202],
          zoom: 13,
          map,
        };
        // create map view by default properties
        this.mapView = new MapView(mapViewProperties);

        // Set service properties
        // url - this address to MapServer from ArcGIS Enterprise
        // sublayers - this are the settings for the inner layers of the service.
        // id = 1 it tell us that will be displayed only one layer with the identifier
        // const oilSandLayerProperties = {
        //   url:
        //     'https://sampleserver6.arcgisonline.com/arcgis/rest/services/OilSandsProjectBoundaries/MapServer',
        //   sublayers: [{ id: 1 }],
        // };
        // // Create map image layer by properties
        // const oilSandsLayer = new MapImageLayer(oilSandLayerProperties);
        // // Adding a layer into map
        // map.add(oilSandsLayer);
        this.hikingTrailFields = [
          {
            name: 'OBJECTID',
            type: 'oid',
          },
          {
            name: 'name',
            type: 'string',
          },
          {
            name: 'length',
            type: 'integer',
          },
          {
            name: 'duration',
            type: 'integer',
          },
          {
            name: 'dificulty',
            type: 'integer',
          },
        ];
      }
    );
  }

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      search: '',
      hasParks: '',
      hasHikingTrails: '',
      hasTouristAttractions: '',
      hasTouristRoutes: '',
    });
  }

  search(): void {
    if (this.searchForm.controls.hasHikingTrails.value) {
      this.service
        .getHikingTrails(this.searchForm.controls.search.value)
        .subscribe((results) => {
          this.hikingTrails = results;
          console.log(this.hikingTrails);
          const hikingTrailGraphics = [];

          loadModules([
            'esri/Map',
            'esri/layers/FeatureLayer',
            'esri/geometry/Point',
            'esri/Graphic',
            'esri/renderers/SimpleRenderer',
            'esri/symbols/WebStyleSymbol',
          ]).then(
            ([
              Map,
              FeatureLayer,
              Point,
              Graphic,
              SimpleRenderer,
              WebStyleSymbol,
            ]: [
              __esri.MapConstructor,
              __esri.FeatureLayerConstructor,
              __esri.PointConstructor,
              __esri.GraphicConstructor,
              __esri.SimpleRendererConstructor,
              __esri.WebStyleSymbolConstructor
            ]) => {
              if ((<__esri.Map>this.map).findLayerById('hikingTrails')) {
                if ((<__esri.Map>this.map).findLayerById('hikingTrails').destroyed === false) {
                  (<__esri.Map>this.map).findLayerById('hikingTrails').destroy();
                  (<__esri.Map>this.map).remove((<__esri.Map>this.map).findLayerById('hikingTrails'));
                }
              }

              this.hikingTrails.forEach((hikingTrail) => {
                hikingTrailGraphics.push(
                  new Graphic({
                    geometry: new Point({
                      latitude:
                        (hikingTrail.activityDetails.yMin +
                          hikingTrail.activityDetails.yMax) /
                        2,
                      longitude:
                        (hikingTrail.activityDetails.xMin +
                          hikingTrail.activityDetails.xMax) /
                        2,
                    }),
                    attributes: {
                      OBJECTID: hikingTrail.id,
                      name: hikingTrail.name,
                      length: hikingTrail.length,
                      duration: hikingTrail.duration,
                      dificulty: hikingTrail.dificulty,
                    },
                  })
                );
              });

              const layer = new FeatureLayer({
                id: 'hikingTrails',
                source: hikingTrailGraphics,
                objectIdField: 'OBJECTID',
                fields: this.hikingTrailFields,
                popupTemplate: {
                  title: 'Hiking Trail: {name}',
                  content: this.hikingTrailPopupHtml,
                },
                renderer: new SimpleRenderer({
                  symbol: new WebStyleSymbol({
                    styleName: 'Esri2DPointSymbolsStyle',
                    name: 'trail',
                    // Get symbol from: https://developers.arcgis.com/javascript/latest/guide/esri-web-style-symbols-2d/index.html
                  }),
                }),
              });

              this.map.add(layer);
            }
          );
        });
    } else {
      loadModules(['esri/Map']).then(([Map]: [__esri.MapConstructor]) => {
        if ((<__esri.Map>this.map).findLayerById('hikingTrails')) {
          if ((<__esri.Map>this.map).findLayerById('hikingTrails').destroyed === false) {
            (<__esri.Map>this.map).findLayerById('hikingTrails').destroy();
            (<__esri.Map>this.map).remove((<__esri.Map>this.map).findLayerById('hikingTrails'));
          }
        }
      });
    }

    if (this.searchForm.controls.hasParks.value) {
      this.service
        .getParks(this.searchForm.controls.search.value)
        .subscribe((results) => {
          this.parks = results;
          console.log(this.parks);
        });
    }

    if (this.searchForm.controls.hasTouristAttractions.value) {
      this.service
        .getTouristAttractions(this.searchForm.controls.search.value)
        .subscribe((results) => {
          this.touristAttractions = results;
          console.log(this.touristAttractions);
        });
    }

    if (this.searchForm.controls.hasTouristRoutes.value) {
      this.service
        .getTouristRoutes(this.searchForm.controls.search.value)
        .subscribe((results) => {
          this.touristRoutes = results;
          console.log(this.touristRoutes);
        });
    }
  }
}
