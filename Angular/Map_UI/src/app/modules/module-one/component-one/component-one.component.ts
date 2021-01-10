import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { HttpService } from '../../../core/http/http.service';
import { EvaluateResponse } from '../../../shared/models/evaluate-response.model';
import { MatTableDataSource } from '@angular/material/table';
import { ConfusionMatrix } from '../../../shared/models/confusion-matrix.model';
import { MatSort } from '@angular/material/sort';
import { SpecificData } from '../../../shared/models/specific-data.model';
import { Prediction } from '../../../shared/models/prediction.model';

@Component({
  selector: 'app-component-one',
  templateUrl: './component-one.component.html',
  styleUrls: ['./component-one.component.scss'],
})
export class ComponentOneComponent implements OnInit {
  constructor(public dialog: MatDialog, public service: HttpService) {}

  ngOnInit(): void {
  }
}
