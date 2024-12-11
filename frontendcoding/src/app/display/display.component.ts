import { Component } from '@angular/core';
import { PlayerService } from '../player.service';
import { Players } from '../model/Players';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent {

  playerList:Players[]=[];

  constructor(private service:PlayerService){

  }


  getAllPlayers(){
    this.service.getAllPlayers().subscribe(
      (input)=>{
        this.playerList=input;
        console.log(input);
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  getAllPlayersSorted(){
    this.service.getAllPlayersSorted().subscribe(
      (input)=>{
        this.playerList=input;
      }
    );
  }
}
