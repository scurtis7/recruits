import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {PlayerService} from "../../service/player.service";
import {Player247} from '../../model/player247';
import {MatSort} from '@angular/material/sort';
import {SessionService} from '../../service/session.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements AfterViewInit {

  displayedColumns: string[] = ['year', 'name', 'position', 'height', 'weight', 'compositeRank', 'rankNational', 'rankPosition', 'rankState', 'stars'];
  dataSource = new MatTableDataSource<Player247>();
  years: String[] = [];
  positions: String[] = [];

  selectedYear: string = 'Select Year';
  selectedPosition: string = 'Select Position';

  @ViewChild(MatSort) sort!: MatSort;

  constructor(private playerService: PlayerService, private sessionService: SessionService, private router: Router) {
  }

  ngAfterViewInit(): void {
    if (!this.sessionService.checkSession()) {
      this.router.navigate(['/signin']);
    }
    console.log('Get Players By College');
    this.playerService.getPlayersByCollege(this.sessionService.session.college)
      .subscribe(result => {
        this.dataSource = new MatTableDataSource(result);
        this.dataSource.sort = this.sort;
      });
    this.playerService.getYears(this.sessionService.session.college)
      .subscribe(result => {
        this.years = result;
      });
    this.playerService.getPositions(this.sessionService.session.college)
      .subscribe(result => {
        this.positions = result;
      });
  }

}
