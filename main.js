window.addEventListener("scroll", () => {
    let val = window.scrollY;
    if(val >= 330.4){
        document.querySelector('.product').style = "animation: scrollAni1;animation-fill-mode: forwards;animation-duration: 3s;animation-timing-function: ease-in-out;animation-iteration-count: 1;";
        document.querySelector('.fst').style = "visibility: visible;animation: textFromRight;animation-fill-mode: forwards;animation-duration: 3s;animation-timing-function: ease-in-out;animation-iteration-count: 1;";
    }else if(val <= 376 & val >= 400){
        document.querySelector('.product').style = "animation: scrollAni1;animation-fill-mode: forwards;animation-duration: 1s;animation-timing-function: ease-in-out;animation-iteration-count: 1;animation-direction: reverse;";
        document.querySelector('.fst').style = "";
    }else{
        document.querySelector('.product').style = "";
        document.querySelector('.fst').style = "";
    }
})