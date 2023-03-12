const date = new Date();
let day = date.getDate();
let month = date.getMonth() + 1;
let year = date.getFullYear();
let currentDate = `${day}-${month}-${year}`;


const getVehicleNo = document.querySelector('.form');
getVehicleNo.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(getVehicleNo);
    const vehicleNo = formData.get('vehilcleNo');
    if (vehicleNo == "") {
        alert("Please enter vehicle license plate number");
    }
    else {
        const billElem = document.getElementById('bill_body');
        billElem.innerHTML = `<h4>ABC Parking</h4><p>==========================</p><p><strong>Date: ${currentDate}</strong></p><p>Vehicle number: ${vehicleNo}</p><p>Parking fees: Rs. 20.00</p><p>Thank you</p>`;
    }

    let park_id, slot, vehicle_Type;

    // get parking details for a particular vehicle
    try {
        const resp1 = await fetch(`http://localhost:8080/park_vision/parking-history/${vehicleNo}`);
        const parkingInfo = await resp1.json();
        console.log(parkingInfo);
        // console.log(typeof(parkingInfo));
        // console.log(parkingInfo[0].phID);
        park_id = parkingInfo[0].phID;
        slot = parkingInfo[0].slotNo;
        vehicle_Type = parkingInfo[0].vehicleType;
        if (!resp1.ok) {
            console.log(parkingInfo.description);
        }
    }
    catch (error) {
        console.log(error);
    }

    // create invoice of parking rent 
    const record_invoice = {
        parkingID: park_id,
        amountPaid: 20
    }
    try {
        const resp2 = await fetch('http://localhost:8080/park_vision//invoice/create-invoice', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(record_invoice)
        });
        const postedData = await resp2.json();
        if (!resp2.ok) {
            console.log(postedData.description);
        }
    } catch (error) {
        console.log(error);
    }

    // update parking slot status as empty
    const updateSLot = {
        slotNo: slot,
        vehicleType: vehicle_Type,
        is_empty: true
    }
    try {
        const resp3 = await fetch(`http://localhost:8080/park_vision/parking-slots/${slot}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updateSLot)
        });
        const updateRes = await resp3.json();
        if (!resp3.ok) {
            console.log(updateRes.description);
        }
    }catch(error){
        console.log(error);
    }
})

// print bill
const printBill = ()=>{
    const areaToPrint = document.getElementById('bill_body');
    const originalContent = document.body.innerHTML;
    document.body.innerHTML = areaToPrint.innerHTML;
    window.print();
    document.body.innerHTML = originalContent;
    location.reload();
}