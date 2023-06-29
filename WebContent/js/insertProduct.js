function previewImage(event) {
  var file = event.target.files[0];
  var preview = document.getElementById('preview-image');
  var previewContainer = document.getElementById('preview-container');

  if (file) {
    var reader = new FileReader();
    reader.onload = function() {
      preview.src = reader.result;
      previewContainer.style.display = 'block'; // プレビューコンテナを表示する
    }
    reader.readAsDataURL(file);
  } else {
    preview.src = ''; // 未選択時はプレビューをクリアする
    previewContainer.style.display = 'none'; // プレビューコンテナを非表示にする
  }
}
