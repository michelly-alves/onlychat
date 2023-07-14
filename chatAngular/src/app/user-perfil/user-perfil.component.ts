import { Component, Input } from '@angular/core';

interface User {


}

@Component({
  selector: 'user-perfil',
  templateUrl: './user-perfil.component.html',
  styleUrls: ['./user-perfil.component.css']
})
export class UserPerfilComponent {
  @Input() usuario: any;
}
