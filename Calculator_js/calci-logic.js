const calci = document.querySelector('.calci');
const keys = document.querySelector('.calci_keyboard');
const display = document.querySelector('.calci_display');
// console.log("display = ",displayedNum);

keys.addEventListener('click', e=> {
    if(e.target.matches('button')){
        const key = e.target;
        const action = key.dataset.action;   
        const keyNumber = key.textContent;
        const displayedNum = display.textContent;
        const prevKeyType = calci.dataset.prevKeyType;

        if(!action){
            console.log("number key");
            calci.dataset.prevKeyType = 'number';
            if(displayedNum === '0' || prevKeyType === 'operator'){
                console.log("replaced 0 with key number");
                display.textContent = keyNumber;
            }
            else{
                console.log(" apppended key number to number on screen");
                display.textContent = displayedNum + keyNumber;
            }
        }
        if(action == 'add'|| action == 'substract'|| action == 'multiply'|| action == 'divide'){
            console.log("operator key");
            key.classList.add('is-depressed');
            calci.dataset.prevKeyType = 'operator';
            calci.dataset.firstNumber = displayedNum;
            calci.dataset.opertor = action;
        }
        if(action == 'clear'){
            console.log("clear key");
            calci.dataset.prevKeyType = 'clear';
            display.textContent = '0';
        }
        if(action == 'decimal'){
            console.log("decimal key");
            calci.dataset.prevKeyType = 'decimal';
            if(!displayedNum.includes('.')){
                display.textContent = displayedNum + '.';
            }
            else if(prevKeyType === 'operator'){
                display.textContent = '.0';
            }
        }
        if(action == 'calculate'){
            console.log("equals key");
            calci.dataset.prevKeyType = 'calculate';
            const num1 = calci.dataset.firstNumber
            const operation = calci.dataset.opertor
            const num2 = displayedNum;
            display.textContent = calculate(num1, num2, operation);
        }
        Array.from(key.parentNode.children).forEach(i => i.classList.remove('is-depressed'));
    }
})

const calculate= (n1, n2, op) => {
    let answer = '';
    n1 = parseFloat(n1);
    n2 = parseFloat(n2);
    if(op === 'add'){
        answer = n1 + n2;
    }
    else if(op === 'subtract'){
        answer = n1 - n2;
    }
    else if(op === 'multiply'){
        answer = n1 * n2;
    }
    else if(op === 'divide'){
        answer = n1 / n2;
    }
    return answer;
}


    


