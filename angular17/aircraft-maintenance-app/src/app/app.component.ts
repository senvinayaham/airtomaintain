import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PartsComponent} from './parts/parts.component';
import { ToolsComponent } from './tools/tools.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PartsComponent, ToolsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'aircraft-maintenance';
}
