
let d_name, dPhNo, vehicle_Type, vehicle_number, slot, countEmpty2, countEmpty4, twoWheeler, fourWheeler;

// get free parking slot count
let availability = async () => {
    try {
        const resp1 = await fetch('http://localhost:8080/park_vision/parking-slots/2');
        const availTwo = await resp1.json();
        countEmpty2 = availTwo.length;
        console.log("countEmpty2: " + countEmpty2);
        twoWheeler = document.getElementById('empty_slots_2');
        twoWheeler.textContent = countEmpty2;
        if (!resp1.ok) {
            console.log(availTwo.description);
        }
    }
    catch (error) {
        console.log(error);
    }
    try {
        const resp2 = await fetch('http://localhost:8080/park_vision/parking-slots/4');
        const availFour = await resp2.json();
        countEmpty4 = availFour.length;
        console.log("countEmpty4: " + countEmpty4);
        fourWheeler = document.getElementById('empty_slots_4');
        fourWheeler.textContent = countEmpty4;
        if (!resp2.ok) {
            console.log(availFour.description);
        }
    }
    catch (error) {
        console.log(error);
    }
}

const parking_details = document.querySelector('.form');
parking_details.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(parking_details);
    d_name = formData.get('driverName');
    dPhNo = formData.get('driverPhNo');
    vehicle_number = formData.get('licensePlateNo');
    vehicle_Type = formData.get('vehicleType');

    if (d_name && dPhNo && vehicle_number && vehicle_Type) {
        if (dPhNo.length == 10) {

            // record parking details
            try {
                const resp3 = await fetch(`http://localhost:8080/park_vision/parking-slots/${parseInt(vehicle_Type)}`);
                const parkingSlotsList = await resp3.json();
                console.log(parkingSlotsList);
                slot = parkingSlotsList[0];
                formData.append("slotNo", slot);
                const data = Object.fromEntries(formData);
                let jsonData = JSON.stringify(data);
                // console.log(data);
                console.log(jsonData);

                // get free parking slot
                try {
                    const resp4 = await fetch('http://localhost:8080/park_vision/parking-history/record-parking', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: jsonData
                    });
                    const parkingRec = await resp4.json();
                    if (!(resp4).ok) {
                        console.log(parkingRec.description);
                    }
                } catch (error) {
                    console.log(error);
                }
                if (!resp3.ok) {
                    console.log(parkingSlotsList.description);
                }
            }
            catch (error) {
                console.log(error);
            }

            const updateSlotStatus = {
                slotNo: slot,
                vehicleType: vehicle_Type,
                is_empty: false
            };
            //console.log(updateSlotStatus);

            // update parking slot status as occupied
            try {
                const resp5 = await fetch(`http://localhost:8080/park_vision/parking-slots/${slot}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(updateSlotStatus)
                });
                const updateRes = await resp5.json();
                if (!resp5.ok) {
                    console.log(updateRes.description);
                }
                alert("Slot allocated: " + slot);
                availability();
                console.log("availability was invoked");
                document.querySelector('.form').reset();
                console.log(updateRes);
            } catch (error) {
                console.log(error);
            }
        }
        else {
            alert("Invalid phone number");
        }
    }
    else {
        alert("Please fill all the form fields");
    }
});
