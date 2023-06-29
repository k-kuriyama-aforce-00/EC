// スライドショーの要素を取得
const slideshow = document.getElementById("slidertype1");
const slides = slideshow.getElementsByTagName("img");

let currentSlide = 0;

// 初期表示のスライドを表示するための関数
function showSlide() {
  // すべてのスライドの表示を非表示にする
  for (let i = 0; i < slides.length; i++) {
    slides[i].classList.remove("active");
  }

  // 現在のスライドを表示する
  slides[currentSlide].classList.add("active");
}

// スライドを切り替えるための関数
function nextSlide() {
  currentSlide++;
  if (currentSlide >= slides.length) {
    currentSlide = 0;
  }
  showSlide();
}

// 一定の間隔でスライドを切り替える
setInterval(nextSlide, 3000);

// 初期表示のスライドを表示する
showSlide();
