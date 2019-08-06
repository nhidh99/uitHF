function addHeaderRows(table, data) {
  const row = document.createElement("tr");
  for (const properties of Object.keys(data)) {
    const cell = document.createElement("th");
    cell.textContent = properties;
    row.appendChild(cell);
  }
  table.appendChild(row);
}

// add data-rows
function addDataRows(table, data) {
  const key = Object.keys(data)[0];
  const numOfdata = data[key].length;

  for (let i = 0; i < numOfdata; i++) {
    const row = document.createElement("tr");
    for (let properties of Object.keys(data)) {
      const cell = document.createElement("td");
      cell.textContent = (data[properties][i]);
      row.appendChild(cell);
    }
    table.appendChild(row);
  }
}

// align right number data
function alignRightNumberInTable() {
  const cells = document.body.getElementsByTagName("td");
  for (const cell of cells) {
    if (!isNaN(cell.textContent)) {
      cell.style.textAlign = "right";
    }
  }
}

// create table
function createTable(table, data) {
  addHeaderRows(table, data);
  addDataRows(table, data);
  alignRightNumberInTable();
}

const table = document.getElementById("mountains");
const mountains_data = {
  name: ["Kilimanjaro", "Everest", "Fansipan", "Fuji"],
  height: ["5895", "8848", "3143", "3776"],
  place: ["Tanzania", "Nepal", "Vietnam", "Japan"]
};

createTable(table, mountains_data);