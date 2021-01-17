import { AfterViewChecked, AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-module-one',
  templateUrl: './module-one.component.html',
  styleUrls: ['./module-one.component.scss']
})
export class ModuleOneComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    let that = this;
    setTimeout(function() { that.router.navigate(['map']); }, 1000);
  }

}
