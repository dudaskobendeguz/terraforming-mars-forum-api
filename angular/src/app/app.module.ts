import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientInMemoryWebApiModule} from "angular-in-memory-web-api";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {InMemoryDataService} from "./services/in-memory-data.service";
import {MessageLoggerComponent} from './components/message-logger/message-logger.component';
import {FooterComponent} from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { CommentComponent } from './components/comment/comment.component';
import { LeaguePostContainerComponent } from './components/league-posts/league-post-container/league-post-container.component';
import { LeaguePostComponent } from './components/league-posts/league-post/league-post.component';
import { UserPostContainerComponent } from './components/user-post-container/user-post-container.component';
import { UserPostComponent } from './components/user-post/user-post.component';


@NgModule({
  declarations: [
    AppComponent,
    MessageLoggerComponent,
    CommentComponent,
    FooterComponent,
    HeaderComponent,
    NavigationBarComponent,
    UserPostContainerComponent,
    UserPostComponent,
    NavigationBarComponent,
    LeaguePostContainerComponent,
    LeaguePostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {dataEncapsulation: false}
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
