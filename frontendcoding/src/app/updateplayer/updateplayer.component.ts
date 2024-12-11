import { Component } from '@angular/core';
import { PlayerService } from '../player.service';
import { Players } from '../model/Players';

@Component({
  selector: 'app-updateplayer',
  templateUrl: './updateplayer.component.html',
  styleUrls: ['./updateplayer.component.css']
})
export class UpdateplayerComponent {

  constructor(private service:PlayerService){

  }


  updatePlayer(updatedInfo:Players){
    this.service.updatePlayer(updatedInfo).subscribe(
      (data)=>{
        alert("Player with Id: "+updatedInfo.playerId+" updated!");
          console.log(updatedInfo);
      },
      (err)=>{
        alert("Update for Player with Id: "+updatedInfo.playerId+" failed!");
        console.log(err);
      }
    );
  }

}
