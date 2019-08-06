const getMyName = () => 'Đinh Hoàng Nhi';
const getMySchool = () => 'University of Information Technology';
const getMyBirthYear = () => '1999';
const button = document.getElementById('submit');
const textarea = document.getElementById('result');

button.addEventListener("click", () => {
    try {
        const e = document.getElementById('function');
        const func = e.options[e.selectedIndex].text;
        textarea.textContent = eval(func);
    }
    catch (e) {
        alert("ERROR ORRCURED!");
    }
});