import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayersComponent } from './components/players/players.component';
import { ScrapeComponent } from './components/scrape/scrape.component';
import { AboutComponent } from './components/about/about.component';
import { SigninComponent } from './components/login/signin/signin.component';
import { SignupComponent } from './components/login/signup/signup.component';

const routes: Routes = [
  {path: '', component: PlayersComponent},
  {path: 'players', component: PlayersComponent},
  {path: 'scrape', component: ScrapeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'signup', component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
