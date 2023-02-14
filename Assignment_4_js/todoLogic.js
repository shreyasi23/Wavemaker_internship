
// task list array
let task_list = [
    {
        task: "Workout",
        status: "pending"
    },
   {
        task: "Write intership diary",
        status: "pending"
    },
    {
        task: "Take Shadow on walk",
        status: "pending"
    },
    {
        task: "Buy grocery",
        status: "pending"
    }
];

// count the number of tasks
let tl_size = task_list.length;
let no_task = document.getElementById("noTask");
no_task.textContent = tl_size;

// counting done and pending tasks
var count_d=0;
for(let i = 0; i < task_list.length; i++){
    if(task_list[i].status === "Done"){
        count_d++;
    }
}
let count_p = task_list.length - count_d;
document.getElementById("d_task").textContent = count_d;
document.getElementById("p_task").textContent = count_p;

// display task list
let list_item;
let myUl = document.getElementById("my_list");
for(let i = 0; i < task_list.length; i++){
    list_item = document.createElement('li');
    list_item.textContent = task_list[i].task;
    myUl.appendChild(list_item);
}

// function to add task to the list
function addTask(){
    var counter=document.getElementById("d_task")
    var count_d=counter.innerHTML;
    count_d++;
    d_task.innerHTMl=count_d;
    let li = document.createElement("li");
    let inputValue = document.getElementById("task").value;
    task_list.push({task:`${inputValue}`, status: "pending"});
    console.log(task_list);
    let work = document.createTextNode(inputValue);
    li.appendChild(work);

    if(inputValue === ''){
        alert("You must enter something");
    }
    else{
        document.getElementById("my_list").appendChild(li);
    }
    document.getElementById("task").value = "";
    tl_size = tl_size + 1;
    no_task.textContent = tl_size;
    count_p = count_p + 1
    document.getElementById("p_task").textContent = count_p;
    console.log(count_p);
}

// function to add check mark and updating task status when li is clicked
let taskList = document.querySelector('ul');
let done_task, li_array, task_index, done, pending;
taskList.addEventListener('click', function (e){
    if(e.target.tagName === 'LI'){
        e.target.classList.toggle('checked');
        // no_task.textContent = tl_size-1;
        li_array = Array.from(e.target.closest("ul").children);
        console.log(li_array);
        task_index = li_array.indexOf(e.target.closest("li"));
        console.log(task_index);
        task_list[task_index].status = "Done";
        console.log("task status updated");
        console.log(task_list);
        e.preventDefault();
        count_d = count_d + 1;
        if(count_d >= tl_size){
            count_d = tl_size;
        }
        count_p = count_p - 1;
        if(count_p <= 0){
            count_p = 0;
        }
        document.getElementById("d_task").textContent = count_d;
        document.getElementById("p_task").textContent = count_p;
        console.log("pending:",count_p);
        console.log("done",count_d);
    }
},false);

