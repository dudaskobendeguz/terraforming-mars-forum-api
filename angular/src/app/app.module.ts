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
import { CommentFormComponent } from './components/comment-form/comment-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LeaguePostContainerComponent } from './components/league-posts/league-post-container/league-post-container.component';
import { LeaguePostComponent } from './components/league-posts/league-post/league-post.component';
import { UserPostContainerComponent } from './components/user-post-components/user-post-container/user-post-container.component';
import { UserPostComponent } from './components/user-post-components/user-post/user-post.component';
import { UserComponent } from './components/user/user.component';
import { UserPostFormComponent } from './components/user-post-components/user-post-form/user-post-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from "@angular/material/slider";
import {MatDialogModule} from "@angular/material/dialog";
import { EditUserPostComponent } from './components/user-post-components/edit-user-post/edit-user-post.component';
import { EditUserPostDialogComponent } from './components/user-post-components/edit-user-post-dialog/edit-user-post-dialog.component';
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    AppComponent,
    MessageLoggerComponent,
    CommentComponent,
    FooterComponent,
    HeaderComponent,
    NavigationBarComponent,
    CommentFormComponent,
    UserPostContainerComponent,
    UserPostComponent,
    NavigationBarComponent,
    LeaguePostContainerComponent,
    LeaguePostComponent,
    UserComponent,
    LeaguePostComponent,
    UserPostFormComponent,
    EditUserPostComponent,
    EditUserPostDialogComponent
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
    ),
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
