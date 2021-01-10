import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponentOneComponent } from './component-one/component-one.component';
import { ModuleOneComponent } from './module-one.component';

import { ModuleOneRouting } from './module-one.routing';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MaterialModule } from './material.module';

@NgModule({
  declarations: [
    ModuleOneComponent,
    ComponentOneComponent,
  ],
  imports: [CommonModule, ModuleOneRouting, FlexLayoutModule, MaterialModule],
})
export class ModuleOneModule {}
