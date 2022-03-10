$.ajax({
    url: "http://localhost:8088/api/admin/traffic",
    type: "GET",
    success: function (data) {
        buildTrafficChart(data);
    }
})
function buildTrafficChart(data) {
    let Traffic = document.getElementById('Traffic').getContext('2d');
    const TrafficChart = new Chart(Traffic, {
        type: 'pie',
        data: {
            labels: ['Facebook', 'Youtube', 'Amazon'],
            datasets: [{
                label: 'Traffic Source',
                data: data,
                backgroundColor: [
                    'rgb(248 126 21)',
                    'rgb(123 142 77)',
                    'rgb(192 161 135)'
                ],
                spacing: 0,
                borderWidth: 0,
            }]
        },
        options: {
            responsive: true,
        }
    });
}

$.getJSON("http://localhost:8088/api/admin/earning").done(function(data) {
    buildEarningChart(data);
})
function buildEarningChart(data) {
    const Earning = document.getElementById('Earning').getContext('2d');
    const EarningChart = new Chart(Earning, {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March',
                'April', 'May', 'June',
                'July', 'August', 'September',
                'October', 'November', 'December'],
            datasets: [{
                label: 'Earning',
                data: data,
                backgroundColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                    'rgba(255, 99, 132, 1)'
                ],
                fill: {
                    target: true,
                    above: 'rgba(248, 126, 21, 0.5)'
                },
                tension: 0.1,
                borderColor: 'rgb(248, 126, 21)',
                borderWidth: 3,
                pointBorderWidth: 5,
            }]
        },
        options: {
            responsive: true,
        }
    });
}