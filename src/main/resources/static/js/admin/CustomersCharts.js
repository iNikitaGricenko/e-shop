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
                'rgb(60,184,229)',
                'rgba(108,108,108,0.9)'
            ],
        }]
    },
    options: {
        responsive: true,
    }
});