import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  usuarios: any[] = [];
  usuariosFiltrados: any[] = [];
  usuarioLogado: any; 

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getUsuarios();
    this.getUsuarioLogado(); 
  }

  getUsuarios() {
    this.http.get<any[]>('http://localhost:8080/api/user')
      .subscribe(
        response => {
          this.usuarios = response;
        },
        error => {
          console.error('Erro ao buscar usuários', error);
          
        }
      );
  }

  getUsuarioLogado() {
  
    this.http.get<any>('http://localhost:8080/api/user/me')
      .subscribe(
        response => {
          this.usuarioLogado = response;
        },
        error => {
          console.error('Erro ao buscar usuário logado', error);
         
        }
      );
  }

  performSearch(searchTerm: string) {
    if (searchTerm) {
      this.usuariosFiltrados = this.usuarios.filter(usuario =>
        (usuario.username && usuario.username.toLowerCase().includes(searchTerm.toLowerCase())) ||
        (usuario.email && usuario.email.toLowerCase().includes(searchTerm.toLowerCase()))
      );
    } else {
      this.usuariosFiltrados = [];
    }
  }
}
