import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Players } from './model/Players';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  baseUrl = "http://localhost:8080/api/cricket";

  constructor(private http:HttpClient) { }


  addPlayer(player:Players):Observable<Players>{
    return this.http.post<Players>(`${this.baseUrl}/add`, player)
  }


  updatePlayer(updatedInfo:Players):Observable<Players>{
    return this.http.put<Players>(`${this.baseUrl}/update/${updatedInfo.playerId}` , updatedInfo);
  }

  getAllPlayers():Observable<Players[]> {
    return this.http.get<Players[]>(`${this.baseUrl}/getAll`);
  }


}
