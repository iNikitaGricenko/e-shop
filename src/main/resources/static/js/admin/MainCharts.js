const TrafficData = [];
TrafficData.push($('#Traffic').attr('data-value1'));
TrafficData.push($('#Traffic').attr('data-value2'));
TrafficData.push($('#Traffic').attr('data-value3'));
const Traffic = document.getElementById('Traffic').getContext('2d');
const Chart1 = new Chart(Traffic, {
    type: 'pie',
    data: {
        labels: ['Facebook', 'Youtube', 'Amazon'],
        datasets: [{
            label: 'Traffic Source',
            data: TrafficData,
            backgroundColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
            ],
        }]
    },
    options: {
        responsive: true,
    }
});
const EarningData = [];
EarningData.push($('#Earning').attr('data-value1'));
EarningData.push($('#Earning').attr('data-value2'));
EarningData.push($('#Earning').attr('data-value3'));
EarningData.push($('#Earning').attr('data-value4'));
EarningData.push($('#Earning').attr('data-value5'));
EarningData.push($('#Earning').attr('data-value6'));
EarningData.push($('#Earning').attr('data-value7'));
EarningData.push($('#Earning').attr('data-value8'));
EarningData.push($('#Earning').attr('data-value9'));
EarningData.push($('#Earning').attr('data-value10'));
EarningData.push($('#Earning').attr('data-value11'));
EarningData.push($('#Earning').attr('data-value12'));
const Earning = document.getElementById('Earning').getContext('2d');
const Chart2 = new Chart(Earning, {
    type: 'bar',
    data: {
        labels: ['January', 'February', 'March',
            'April', 'May', 'June',
            'July', 'August', 'September',
            'October', 'November', 'December'],
        datasets: [{
            label: 'Earning',
            data: EarningData,
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
        }]
    },
    options: {
        responsive: true,
    }
});