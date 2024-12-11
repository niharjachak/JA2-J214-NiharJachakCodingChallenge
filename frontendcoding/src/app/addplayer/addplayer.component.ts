import { Component } from '@angular/core';
import { PlayerService } from '../player.service';
import { Players } from '../model/Players';

@Component({
  selector: 'app-addplayer',
  templateUrl: './addplayer.component.html',
  styleUrls: ['./addplayer.component.css']
})
export class AddplayerComponent {

    constructor(private service:PlayerService){

    }

    addPlayer(player:Players){
      this.service.addPlayer(player).subscribe(
        (data)=>{
          console.log(data);
          alert("Player Registeration Succesfull");
        },
        (err)=>{
          console.log(err);
          alert("Player Registeration Failed")

        }
      );
    }

}
