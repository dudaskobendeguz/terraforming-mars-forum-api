import {Component, Input, OnInit} from '@angular/core';


/**
 * Component generates an icon with small detailed information from the icon in the bottom right corner
 * and with tooltip information.
 * @param {string} message - small icon "value" detail
 * @param {string} tooltip - detail from the icon(in tooltip)
 * @param {string} matIconType - the type of the icon. This component using mat-icon material.
 * {@link https://www.angularjswiki.com/angular/angular-material-icons-list-mat-icon-list/ available icons}
 */
@Component({
  selector: 'app-icon',
  templateUrl: './icon.component.html',
  styleUrls: ['./icon.component.css']
})
export class IconComponent implements OnInit {
  @Input() message?: number | string;
  @Input() tooltip?: string;
  @Input() matIconType?: string;

  constructor() { }

  ngOnInit(): void {
  }

}
