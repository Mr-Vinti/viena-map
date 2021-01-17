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
  <span>Difficulty grade: {dificulty}</span>';
  parksFields: any;
  parksPopupHtml =
    '<span>Surface: {surface} square meters</span><br>\
  <span>Playgrounds: {playgrounds}</span><br>\
  <span>Pet Spaces: {petspaces}</span>';
  touristAttractionsFields: any;
  touristAttractionsPopupHtml =
    '<span>Objective Image:</span><br>\
    <img src="{url}"></img>';
  touristRoutesFields: any;
  touristRoutesPopupHtml =
    '<span>Length: {length} kilometers</span><br>\
  <span>Number of Touristic Objectives: {objectivesNumber}</span>';

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

        this.parksFields = [
          {
            name: 'OBJECTID',
            type: 'oid',
          },
          {
            name: 'name',
            type: 'string',
          },
          {
            name: 'surface',
            type: 'integer',
          },
          {
            name: 'playgrounds',
            type: 'string',
          },
          {
            name: 'petspaces',
            type: 'string',
          },
        ];

        this.touristAttractionsFields = [
          {
            name: 'OBJECTID',
            type: 'oid',
          },
          {
            name: 'name',
            type: 'string',
          },
          {
            name: 'url',
            type: 'string',
          },
        ];

        this.touristRoutesFields = [
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
            name: 'objectivesNumber',
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

          if (this.hikingTrails.length) {
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
                  if (
                    (<__esri.Map>this.map).findLayerById('hikingTrails')
                      .destroyed === false
                  ) {
                    (<__esri.Map>this.map)
                      .findLayerById('hikingTrails')
                      .destroy();
                    (<__esri.Map>this.map).remove(
                      (<__esri.Map>this.map).findLayerById('hikingTrails')
                    );
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
          }
        });
    } else {
      loadModules(['esri/Map']).then(([Map]: [__esri.MapConstructor]) => {
        if ((<__esri.Map>this.map).findLayerById('hikingTrails')) {
          if (
            (<__esri.Map>this.map).findLayerById('hikingTrails').destroyed ===
            false
          ) {
            (<__esri.Map>this.map).findLayerById('hikingTrails').destroy();
            (<__esri.Map>this.map).remove(
              (<__esri.Map>this.map).findLayerById('hikingTrails')
            );
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

          if (this.parks.length) {
            const parksGraphics = [];

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
                if ((<__esri.Map>this.map).findLayerById('parks')) {
                  if (
                    (<__esri.Map>this.map).findLayerById('parks').destroyed ===
                    false
                  ) {
                    (<__esri.Map>this.map).findLayerById('parks').destroy();
                    (<__esri.Map>this.map).remove(
                      (<__esri.Map>this.map).findLayerById('parks')
                    );
                  }
                }

                this.parks.forEach((park) => {
                  parksGraphics.push(
                    new Graphic({
                      geometry: new Point({
                        latitude:
                          (park.activityDetails.yMin +
                            park.activityDetails.yMax) /
                          2,
                        longitude:
                          (park.activityDetails.xMin +
                            park.activityDetails.xMax) /
                          2,
                      }),
                      attributes: {
                        OBJECTID: park.id,
                        name: park.name,
                        surface: park.surface,
                        playgrounds: park.playgrounds === true ? 'Yes' : 'No',
                        petspaces: park.petspaces === true ? 'Yes' : 'No',
                      },
                    })
                  );
                });

                const layer = new FeatureLayer({
                  id: 'parks',
                  source: parksGraphics,
                  objectIdField: 'OBJECTID',
                  fields: this.parksFields,
                  popupTemplate: {
                    title: 'Park: {name}',
                    content: this.parksPopupHtml,
                  },
                  renderer: new SimpleRenderer({
                    symbol: new WebStyleSymbol({
                      styleName: 'Esri2DPointSymbolsStyle',
                      name: 'park',
                      // Get symbol from: https://developers.arcgis.com/javascript/latest/guide/esri-web-style-symbols-2d/index.html
                    }),
                  }),
                });

                this.map.add(layer);
              }
            );
          }
        });
    } else {
      loadModules(['esri/Map']).then(([Map]: [__esri.MapConstructor]) => {
        if ((<__esri.Map>this.map).findLayerById('parks')) {
          if (
            (<__esri.Map>this.map).findLayerById('parks').destroyed === false
          ) {
            (<__esri.Map>this.map).findLayerById('parks').destroy();
            (<__esri.Map>this.map).remove(
              (<__esri.Map>this.map).findLayerById('parks')
            );
          }
        }
      });
    }

    if (this.searchForm.controls.hasTouristAttractions.value) {
      this.service
        .getTouristAttractions(this.searchForm.controls.search.value)
        .subscribe((results) => {
          this.touristAttractions = results;
          console.log(this.touristAttractions);

          if (this.touristAttractions.length) {
            const touristAttractionsGraphics = [];

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
                if (
                  (<__esri.Map>this.map).findLayerById('touristAttractions')
                ) {
                  if (
                    (<__esri.Map>this.map).findLayerById('touristAttractions')
                      .destroyed === false
                  ) {
                    (<__esri.Map>this.map)
                      .findLayerById('touristAttractions')
                      .destroy();
                    (<__esri.Map>this.map).remove(
                      (<__esri.Map>this.map).findLayerById('touristAttractions')
                    );
                  }
                }

                this.touristAttractions.forEach((touristAttraction) => {
                  touristAttractionsGraphics.push(
                    new Graphic({
                      geometry: new Point({
                        latitude:
                          (touristAttraction.activityDetails.yMin +
                            touristAttraction.activityDetails.yMax) /
                          2,
                        longitude:
                          (touristAttraction.activityDetails.xMin +
                            touristAttraction.activityDetails.xMax) /
                          2,
                      }),
                      attributes: {
                        OBJECTID: touristAttraction.id,
                        name: touristAttraction.name,
                        url:
                          !touristAttraction.url
                            ? 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/480px-No_image_available.svg.png'
                            : touristAttraction.url,
                      },
                    })
                  );
                });

                const layer = new FeatureLayer({
                  id: 'touristAttractions',
                  source: touristAttractionsGraphics,
                  objectIdField: 'OBJECTID',
                  fields: this.touristAttractionsFields,
                  popupTemplate: {
                    title: 'Touristic Objective: {name}',
                    content: [
                      {
                        type: 'media',
                        mediaInfos: [
                          {
                            title: '',
                            caption: '',
                            value: {
                              sourceURL: '{url}',
                            },
                          },
                        ],
                      },
                    ],
                  },
                  renderer: new SimpleRenderer({
                    symbol: new WebStyleSymbol({
                      styleName: 'Esri2DPointSymbolsStyle',
                      name: 'landmark',
                      // Get symbol from: https://developers.arcgis.com/javascript/latest/guide/esri-web-style-symbols-2d/index.html
                    }),
                  }),
                });

                this.map.add(layer);
              }
            );
          }
        });
    } else {
      loadModules(['esri/Map']).then(([Map]: [__esri.MapConstructor]) => {
        if ((<__esri.Map>this.map).findLayerById('touristAttractions')) {
          if (
            (<__esri.Map>this.map).findLayerById('touristAttractions')
              .destroyed === false
          ) {
            (<__esri.Map>this.map)
              .findLayerById('touristAttractions')
              .destroy();
            (<__esri.Map>this.map).remove(
              (<__esri.Map>this.map).findLayerById('touristAttractions')
            );
          }
        }
      });
    }

    if (this.searchForm.controls.hasTouristRoutes.value) {
      this.service
        .getTouristRoutes(this.searchForm.controls.search.value)
        .subscribe((results) => {
          this.touristRoutes = results;
          console.log(this.touristRoutes);
          if (this.touristRoutes.length) {
            const touristRoutesGraphics = [];

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
                if ((<__esri.Map>this.map).findLayerById('touristRoutes')) {
                  if (
                    (<__esri.Map>this.map).findLayerById('touristRoutes')
                      .destroyed === false
                  ) {
                    (<__esri.Map>this.map)
                      .findLayerById('touristRoutes')
                      .destroy();
                    (<__esri.Map>this.map).remove(
                      (<__esri.Map>this.map).findLayerById('touristRoutes')
                    );
                  }
                }

                this.touristRoutes.forEach((touristRoute) => {
                  touristRoutesGraphics.push(
                    new Graphic({
                      geometry: new Point({
                        latitude:
                          (touristRoute.activityDetails.yMin +
                            touristRoute.activityDetails.yMax) /
                          2,
                        longitude:
                          (touristRoute.activityDetails.xMin +
                            touristRoute.activityDetails.xMax) /
                          2,
                      }),
                      attributes: {
                        OBJECTID: touristRoute.id,
                        name: touristRoute.name,
                        length: touristRoute.length,
                        objectivesNumber: touristRoute.objectivesNumber,
                      },
                    })
                  );
                });

                const layer = new FeatureLayer({
                  id: 'touristRoutes',
                  source: touristRoutesGraphics,
                  objectIdField: 'OBJECTID',
                  fields: this.touristRoutesFields,
                  popupTemplate: {
                    title: 'Touristic Route : {name}',
                    content: this.touristRoutesPopupHtml,
                  },
                  renderer: new SimpleRenderer({
                    symbol: new WebStyleSymbol({
                      styleName: 'Esri2DPointSymbolsStyle',
                      name: 'flag',
                      // Get symbol from: https://developers.arcgis.com/javascript/latest/guide/esri-web-style-symbols-2d/index.html
                    }),
                  }),
                });

                this.map.add(layer);
              }
            );
          }
        });
    } else {
      loadModules(['esri/Map']).then(([Map]: [__esri.MapConstructor]) => {
        if ((<__esri.Map>this.map).findLayerById('touristRoutes')) {
          if (
            (<__esri.Map>this.map).findLayerById('touristRoutes').destroyed ===
            false
          ) {
            (<__esri.Map>this.map).findLayerById('touristRoutes').destroy();
            (<__esri.Map>this.map).remove(
              (<__esri.Map>this.map).findLayerById('touristRoutes')
            );
          }
        }
      });
    }
  }
}
