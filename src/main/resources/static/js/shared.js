const generateRandomId = (prefix, length) => {
  const randomString = Math.random()
    .toString(36)
    .substring(2, length + 2);
  return prefix + randomString;
};

const removeToast = (toastID) => {
  const html = document.getElementsByTagName("html")[0];
  const toast = document.getElementById(toastID);
  html.removeChild(toast);
  return;
};

const createToast = (message, type, timeout = 2000) => {
  const html = document.getElementsByTagName("html")[0];
  const toast = document.createElement("div");
  const toastID = generateRandomId("toast_", 8);
  toast.id = toastID;
  toast.className = "live_toast";
  toast.innerHTML = `
    <div class="showup toast_portal">
      <div id="toast-success" class="toast_body" role="alert">
        <div
          class="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-green-500 bg-green-100 rounded-lg dark:bg-green-800 dark:text-green-200"
        >
          <svg
            aria-hidden="true"
            class="toast_icon"
            fill="currentColor"
            viewBox="0 0 20 20"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </div>
        <div class="toast_text">${message}</div>
        <button
          onclick="()=>removeToast(${toastID})"
          type="button"
          class="toast_exit"
          data-dismiss-target="#toast-success"
          aria-label="Close"
        >
          <svg
            aria-hidden="true"
            fill="currentColor"
            viewBox="0 0 20 20"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </button>
      </div>
    </div>
    `;
  html.appendChild(toast);
  setTimeout(() => removeToast(toastID), timeout);
};
