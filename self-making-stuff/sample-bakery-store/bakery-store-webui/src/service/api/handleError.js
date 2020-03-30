export const handleError = (status) => {
    switch (status) {
        case 403: {
            localStorage.removeItem('token');
            window.location.href = "/login";
            break;
        }
        default: {
            window.location.href = "/exception";
            break;            
        }
    }
}