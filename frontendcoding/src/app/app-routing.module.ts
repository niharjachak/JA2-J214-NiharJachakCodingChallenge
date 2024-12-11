import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayComponent } from './display/display.component';
import { AddplayerComponent } from './addplayer/addplayer.component';
import { UpdateplayerComponent } from './updateplayer/updateplayer.component';

const routes: Routes = [
  {path:'display',component:DisplayComponent},
  {path:'add-player',component:AddplayerComponent},
  {path:'update-player',component:UpdateplayerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
