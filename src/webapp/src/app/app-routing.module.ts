import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import { PlayersComponent } from './components/players/players.component';
import { ScrapeComponent } from './components/scrape/scrape.component';
import { AboutComponent } from './components/about/about.component';
import { SigninComponent } from './components/signin/signin.component';

const routes: Routes = [
  {path: 'players', component: PlayersComponent},
  {path: 'scrape', component: ScrapeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'signin', component: SigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
