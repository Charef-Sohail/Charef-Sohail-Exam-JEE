import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Clients} from './components/clients/clients';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Clients],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend-assurance');
}
