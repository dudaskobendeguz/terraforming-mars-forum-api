import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateAgo'
})
export class DateAgoPipe implements PipeTransform {

  private intervals: {[key: string]: number} = {
    'year': 60*60*24*365,
    'month': 60*60*24*30,
    'week': 60*60*24*7,
    'day': 60*60*24,
    'hour': 60*60,
    'minute': 60,
    'second': 1
  };
  transform(value: Date | string | null): string | Date | null {
    if (value) {
      const dateAgo: Date = (value instanceof Date)? value : new Date(value);
      const seconds = Math.floor((+new Date() - +dateAgo) / 1000);

      if (seconds < 29) {
        return 'Just now';
      }

      let counter;
      for (const interval in this.intervals) {
        counter = Math.floor(seconds / this.intervals[interval]);
        if (counter === 1) {
          return `${counter} ${interval} ago`;
        }
        else if (counter > 1){
          return `${counter} ${interval}s ago`;
        }
      }
    }
    return value;
  }
}
