import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

import {FormsModule} from '@angular/forms';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  locations=[];

  apelido='';
  cep='';

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.listAll();

  }

  listAll() : void{
    this.apiService.get().subscribe((data: any[])=>{
			console.log(data);
			this.locations = data;
		})
  }
  onExcludeClick(location) : void {
    console.log("Excluir");

    this.apiService.delete(location.id).subscribe((data: any[])=>{
      this.listAll();
    });
  }

  setApelido(apelido: string){
    this.apelido = apelido;
  }
  setCep(cep: string){
    this.cep = cep;
  }

  saveNew() : void{
    this.apiService.post(this.apelido,this.cep).subscribe((data: any[])=>{
      this.apelido = '';
      this.cep = '';
      this.listAll();
    });
  }

}
