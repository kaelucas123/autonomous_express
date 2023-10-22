import { Component } from '@angular/core';

@Component({
  selector: 'app-management',
  templateUrl: './management.component.html',
  styleUrls: ['./management.component.scss']
})
export class ManagementComponent {
  shouldRun = /(^|.)(stackblitz|webcontainer).(io|com)$/.test(window.location.host);
}
