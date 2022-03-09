const OnlineTrafficData = [];
OnlineTrafficData.push($('#OnlineTraffic').attr('data-value1'));
OnlineTrafficData.push($('#OnlineTraffic').attr('data-value2'));
const OnlineTraffic = document.getElementById('OnlineTraffic').getContext('2d');
const Chart3 = new Chart(OnlineTraffic, {
    type: 'doughnut',
    data: {
        labels: ['Online', 'Offline'],
        datasets: [{
            label: 'Online Traffic',
            data: OnlineTrafficData,
            backgroundColor: [
                'rgb(141 224 44)',
                'rgb(192 161 135)'
            ],
        }]
    },
    options: {
        responsive: true,
    }
});