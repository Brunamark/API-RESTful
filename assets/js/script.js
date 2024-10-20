
document.addEventListener('DOMContentLoaded', async function () {
    const url = "http://localhost:8080/task/user/1";

    function hideLoader() {
        document.getElementById("loading").style.display = "none";
    }

    function show(tasks) {

        let tab = `<thead>
            <th scope="col">#</th>
            <th scope="col">Description</th>
            <th scope="col">Username</th>
            <th scope="col">User id</th>
        </thead>`;
        /*
        const table = document.querySelector('#table-task');
        table.setAttribute("thead")*/

        for (let task of tasks) {
            console.log("task.id", task.id)
            tab += `
                <tr>
                    <td scope="row">${task.id}</td>
                    <td>${task.description}</td>
                    <td>${task.user.username}</td>
                    <td>${task.user.id}</td>
                </tr>`;
        }
        
        const taskElement = document.querySelector("#tasks");
        taskElement.innerHTML = tab;
     
        
    }


    async function getApi(url) {
        const response = await fetch(url, {method: "GET"});

        let data = await response.json();
        console.log("data: ", data);
        if(response){
            hideLoader();
        }
        show(data)
    }

    getApi(url);
});