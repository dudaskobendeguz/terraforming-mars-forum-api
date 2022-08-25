import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserPostContainerComponent} from "./components/user-post-components/user-post-container/user-post-container.component";
import {
  LeaguePostContainerComponent
} from "./components/league-posts/league-post-container/league-post-container.component";
import {ProfilePageComponent} from "./components/user/profile-page/profile-page.component";

const routes: Routes = [
  {path: 'user-posts', component: UserPostContainerComponent},
  {path: 'league-posts', component: LeaguePostContainerComponent},
  {path: 'profile', component: ProfilePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
