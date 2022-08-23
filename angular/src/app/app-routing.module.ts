import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserPostContainerComponent} from "./components/user-post-container/user-post-container.component";
import {
  LeaguePostContainerComponent
} from "./components/league-posts/league-post-container/league-post-container.component";

const routes: Routes = [
  {path: 'user-posts', component: UserPostContainerComponent},
  {path: 'league-posts', component: LeaguePostContainerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
