import { Component, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { Chart, ChartConfiguration, LinearScale, CategoryScale, BarElement, Title, Tooltip, Legend, LineElement, ArcElement, LineController, BarController } from 'chart.js';

// Đăng ký các thành phần từ Chart.js
Chart.register(LinearScale, CategoryScale, BarElement, Title, Tooltip, Legend, LineElement, LineController, BarController);

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  @ViewChild('overviewChart') overviewChartRef!: ElementRef<HTMLCanvasElement>;
  @ViewChild('detailsChart') detailsChartRef!: ElementRef<HTMLCanvasElement>;

  ngAfterViewInit(): void {
    this.createOverviewChart();
    this.createDetailsChart();
  }

  private createOverviewChart(): void {
    const overviewCtx = this.overviewChartRef.nativeElement.getContext('2d');
    if (overviewCtx) {
      const overviewConfig: ChartConfiguration<'bar'> = {
        type: 'bar',
        data: {
          labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6'],
          datasets: [{
            label: 'Doanh thu (VNĐ)',
            data: [12000000, 15000000, 13000000, 20000000, 18000000, 16000000],
            backgroundColor: 'rgba(54, 162, 235, 0.6)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 1
          }]
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      };

      new Chart(overviewCtx, overviewConfig);
    }
  }

  private createDetailsChart(): void {
    const detailsCtx = this.detailsChartRef.nativeElement.getContext('2d');
    if (detailsCtx) {
      const detailsConfig: ChartConfiguration<'bar'> = {
        type: 'bar',
        data: {
          labels: ['Tuần 1', 'Tuần 2', 'Tuần 3', 'Tuần 4', 'Tuần 5'],
          datasets: [{
            label: 'Lượng bán hàng (Sản phẩm)',
            data: [300, 400, 350, 500, 450],
            backgroundColor: 'rgba(255, 99, 132, 0.6)',
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 2,
          }]
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      };

      new Chart(detailsCtx, detailsConfig);
    }
  }
}
