const fontsURLs = [
  `https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap`,
];

const addFonts = () => {
  let head = document.getElementsByTagName("head")[0];
  let html = document.getElementsByTagName("html")[0];
  let link = document.createElement("link");
  link.rel = "preconnect";
  link.href = "https://fonts.googleapis.com";
  head.appendChild(link);
  link = document.createElement("link");
  link.rel = "preconnect";
  link.href = "https://fonts.gstatic.com";
  link.crossOrigin = true;
  head.appendChild(link);
  fontsURLs.forEach((url) => {
    link = document.createElement("link");
    link.href = url;
    link.rel = "stylesheet";
    head.appendChild(link);
  });
  const script = document.createElement("script");
  script.src = "https://cdn.tailwindcss.com";
  head.appendChild(script);
  const tailwindStyles = document.createElement("style");
  tailwindStyles.type = "text/tailwindcss";
  tailwindStyles.innerHTML = `
    @layer components {
      .main_grid {
        @apply container mx-auto w-screen h-screen flex flex-col justify-center;
      }
      .main_grid_wrapper {
        @apply min-h-[60vh] flex bg-[#FFF];
      }
    }
    @layer utilities {
      .navbar_links_hover::after {
        user-select: none;
        content: "";
        position: absolute;
        bottom: -4px;
        left: -8px;
      
        display: block;
        width: 0;
        height: 1px;
        background: var(--main-black);
        transition: width 0.2s ease-in-out;
      }
      
      .navbar_links_hover:hover::after {
        width: calc(100% + 16px);
      }
    }
  `;
  head.appendChild(tailwindStyles);
};
addFonts();
