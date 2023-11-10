document.addEventListener('DOMContentLoaded', function () {
    const ticketForm = document.getElementById('ticket-form');
    const ticketList = document.getElementById('ticket-items');
    // const bookedTicketSection = document.getElementById('booked-ticket-section');
    // const printButton = document.getElementById('print-button');

    ticketForm.addEventListener('submit', function (e) {
        e.preventDefault();

        // Extract form data
        const routeSelect = document.getElementById('route'),
            passengerName = document.getElementById('passenger-name').value,
            departureTime = document.getElementById('departure-time').value,
            originSelect = document.getElementById('origin'),
            destinationSelect = document.getElementById('destination'),
            ticketClassSelect = document.getElementById('class'),
            busTypeSelect = document.getElementById('bus-type');
        // Retrieve selected items
        const route = routeSelect.options[routeSelect.selectedIndex].textContent,
            origin = originSelect.options[originSelect.selectedIndex].textContent,
            destination = destinationSelect.options[destinationSelect.selectedIndex].textContent,
            ticketClass = ticketClassSelect.options[ticketClassSelect.selectedIndex].textContent,
            busType = busTypeSelect.options[busTypeSelect.selectedIndex].textContent;

        const price = '$30.00';

        // Construct the ticket details
        const ticketDetails = `
            You are going to ${destination} from ${origin}
            
            Route: ${route}
            Passenger: ${passengerName}
            Departure Time: ${departureTime}
            Origin: ${origin}
            Destination: ${destination}
            Class: ${ticketClass}
            Bus Type: ${busType}
            
            Price: ${price}
        `;

        // Create a new list item to display the submitted data
        const listItem = document.createElement('li');
        listItem.classList.add('ticket-item');
        listItem.textContent = ticketDetails;
        ticketList.appendChild(listItem);

        // Clear the form inputs
        ticketForm.reset();

        // Display the submitted data in the booked ticket section
        // bookedTicketSection.innerHTML = `You have submitted the following details: <br>${submittedData}`;
    });

    // ticketForm.addEventListener('submit', function (e) {
    //     e.preventDefault();
    //
    //     console.log("Form submitted")
    //
    //     // Extract form data
    //     const route = document.getElementById('route').value;
    //     const passengerName = document.getElementById('passenger-name').value;
    //     const departureTime = document.getElementById('departure-time').value;
    //     const origin = document.getElementById('origin').value;
    //     const destination = document.getElementById('destination').value;
    //     const ticketClass = document.getElementById('class').value;
    //     const busType = document.getElementById('bus-type').value;
    //
    //     // Make an API request to book a ticket using fetch or XMLHttpRequest
    //     // Handle the response and update the ticket list and the booked ticket section
    //     // Example using fetch:
    //     fetch('/api/bookings', {
    //         method: 'POST', headers: {
    //             'Content-Type': 'application/json',
    //         },
    //
    //         body: JSON.stringify({
    //             route: route,
    //             passengerName: passengerName,
    //             departureTime: departureTime,
    //             origin: origin,
    //             destination: destination,
    //             ticketClass: ticketClass,
    //             busType: busType,
    //         }),
    //     })
    //         .then(response => response.json())
    //         .then(data => {
    //             // Handle the response and add the booked ticket to the list
    //             const listItem = document.createElement('li');
    //             listItem.classList.add('ticket-item');
    //             listItem.textContent = `Route: ${data.route}, Passenger: ${data.passengerName},
    //             Departure Time: ${data.departureTime}, Origin: ${data.origin}, Destination: ${data.destination},
    //             Class: ${data.ticketClass}, Bus Type: ${data.busType}`;
    //             ticketList.appendChild(listItem);
    //
    //             // Display the booked ticket in the booked ticket section
    //             bookedTicketSection.innerHTML = `You have booked a ticket with the following details:
    //             Route: ${data.route}<br>
    //             Passenger: ${data.passengerName}<br>
    //             Departure Time: ${data.departureTime}<br>
    //             Origin: ${data.origin}<br>
    //             Destination: ${data.destination}<br>
    //             Class: ${data.ticketClass}<br>
    //             Bus Type: ${data.busType}`;
    //
    //             // Clear the form inputs
    //             ticketForm.reset();
    //         })
    //
    //         .catch(error => {
    //             console.error('Error booking ticket: ', error);
    //         });
    // });

    // Function to print the ticket
    // function printTicket(ticketItem) {
    //     // Create a new window for printing
    //     const printWindow = window.open('', '', 'width=600,height=600');
    //     printWindow.document.open();
    //     printWindow.document.write('<html lang="en"><head><title>Ticket</title></head><body>');
    //     printWindow.document.write('<h1>Your Ticket</h1>');
    //     printWindow.document.write('<p>' + ticketItem.textContent + '</p>');
    //     printWindow.document.write('</body></html>');
    //     printWindow.document.close();
    //
    //     // Focus and print the new window
    //     printWindow.focus();
    //     printWindow.print();
    //     printWindow.close();
    // }

    // if (printButton) {
    //     printButton.addEventListener('click', function () {
    //         printTicket(bookedTicketSection);
    //     });
    // }
});