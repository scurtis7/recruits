import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ScraperService } from './service/scraper.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { AboutComponent } from './components/about/about.component';
import { SigninComponent } from './components/login/signin/signin.component';
import { PlayersComponent } from './components/players/players.component';
import { ScrapeComponent } from './components/scrape/scrape.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    SigninComponent,
    PlayersComponent,
    ScrapeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSortModule,
    MatTableModule
  ],
  providers: [
    ScraperService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
