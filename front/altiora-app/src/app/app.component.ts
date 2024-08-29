import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'altiora-app';

  showButom : boolean = false;

  constructor(private router: Router){
    this.showButom = true;
    console.log(this.showButom);
    console.log(router.url);
  }

  ngOnDestroy(): void {
    this.showButom = false;
    
  }

}
