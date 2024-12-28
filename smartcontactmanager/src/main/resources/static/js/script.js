// console.log("This is js file");

const toggleSidebar = () => {
    const sidebar = document.querySelector(".sidebar");
    const content = document.querySelector(".content");

    if (getComputedStyle(sidebar).display !== "none") {
        sidebar.style.display = "none";
        content.style.marginLeft = "0%";
    } else {
        sidebar.style.display = "block";
        content.style.marginLeft = "20%";
    }
};

const search = () => {
    let query = document.getElementById("search-input").value.trim();
    // console.log(query);

    const searchResult = document.querySelector(".search-result");
    if (query === "") {
        searchResult.style.display = "none";
    } else {
        let url = `http://localhost:8080/search/${encodeURIComponent(query)}`;
        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then((data) => {
                // console./log("Search Results:", data);
                let text = `<div class='list-group'>`;

                data.forEach((contact) => {
                    text += `<a href='/user/${contact.cId}/contact' class="list-group-item list-group-item-action">${contact.name}</a>`;
                });
                text += `</div>`;

                searchResult.innerHTML = text;
                searchResult.style.display = "block";
            })
            .catch((error) => {
                console.error("Error during search:", error);
            });
    }
};

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("search-input").addEventListener("keyup", search);
});
