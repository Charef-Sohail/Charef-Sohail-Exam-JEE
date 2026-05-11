import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Assurance} from '../../services/assurance';

@Component({
  selector: 'app-clients',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './clients.html',
  styleUrl: './clients.css'
})
export class Clients implements OnInit {
  public clients: any;

  constructor(private assuranceService: Assurance) {}

  ngOnInit(): void {
    this.assuranceService.getClients().subscribe({
      next: (data) => {
        console.log(data);
        this.clients = data;
      },
      error: (err) => {
        console.error("Erreur lors de la récupération des clients", err);
      }
    });
  }
}
