import { NgModule, ModuleWithProviders } from '@angular/core';


@NgModule({
    declarations: [],
    exports: [

    ]
  })
  export class ServiceModule {
      static forRoot(): ModuleWithProviders {
          return {
              ngModule: ServiceModule
          };
        }
    }
