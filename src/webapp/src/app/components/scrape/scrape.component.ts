import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Player247 } from '../../model/player247';
import { College } from '../../model/college';
import { ScraperService } from '../../service/scraper.service';
import { CollegeService } from '../../service/college.service';
import { SessionService } from '../../service/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-scrape',
  templateUrl: './scrape.component.html',
  styleUrls: ['./scrape.component.css']
})
export class ScrapeComponent implements OnInit {

  displayedColumns: string[] = ['year', 'name', 'position', 'height', 'weight', 'compositeRank', 'rankNational', 'rankPosition', 'rankState', 'stars'];
  dataSource = new MatTableDataSource<Player247>();
  colleges: College[] = [];
  selectedCollege: string = '';
  selectedYear: string = '';
  errorFound: boolean = false;
  errorMsg: string = '';

  constructor(private scraperService: ScraperService, private collegeService: CollegeService,
              private sessionService: SessionService, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.sessionService.checkSession()) {
      this.router.navigate(['/signin']);
    }
    // this.players = [
    //   {siteId:"siteId", name:"name", position: "position", height:"height", weight:"weight", homeTown:"homeTown", highSchool:"highSchool", year:"year", compositeRank:"cRank", rankNational:"nRank", rankPosition:"pRank", rankState:"sRank", stars:"stars", link:"link"}
    // ]
    // this.colleges = [
    //   {id: 1, siteName: 'florida-state', displayName: 'Florida State University', conference: 'ACC', division: 'Atlantic'},
    //   {id: 2, siteName: 'georgia', displayName: 'University of Georgia', division: '', conference: ''},
    //   {id: 3, siteName: 'auburn', displayName: 'Auburn University', conference: '', division: ''},
    //   {id: 4, siteName: 'alabama', displayName: 'University of Alabama', conference: '', division: ''}
    // ];
    this.loadAllColleges();
    this.selectedCollege = 'florida-state';
  }

  loadAllColleges(): void {
    this.collegeService.getAllColleges()
      .subscribe(result => {
        this.colleges = result;
      });
  }

  scrape(): void {
    console.log('selected college: ' + this.selectedCollege)
    console.log('   selected year: ' + this.selectedYear)
    if (this.selectedYear === undefined || this.selectedYear === '') {
      this.errorFound = true;
      this.errorMsg = 'Please enter a year';
    } else {
      this.errorFound = false;
      this.scraperService.scrape(this.selectedCollege, this.selectedYear)
        .subscribe(result => {
          this.dataSource = new MatTableDataSource(result);
        });
    }
  }

}
