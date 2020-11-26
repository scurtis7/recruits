import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { SigninComponent } from './components/signin/signin.component';
import { PlayersComponent } from './components/players/players.component';
import { ScrapeComponent } from './components/scrape/scrape.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    SigninComponent,
    PlayersComponent,
    ScrapeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
