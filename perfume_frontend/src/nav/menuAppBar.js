import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import IconButton from "@material-ui/core/IconButton";
import AccountCircle from "@material-ui/icons/AccountCircle";
import MenuItem from "@material-ui/core/MenuItem";
import Menu from "@material-ui/core/Menu";
import MainMenuItem from "./mainMenu/mainMenuItem.js";
import MenuButton from "./mainMenu/menuButton.js";
import MainMenu from "./mainMenu/mainMenu.js"

export default function MenuAppBar(props) {
  const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    menuButton: {
      marginRight: theme.spacing(2),
    },
    title: {
      flexGrow: 1,
    },
  }));

  const classes = useStyles();
  const [anchorEl, setAnchorEl] = useState(null);
  const [menuOpen, setMenuOpen] = useState(false);
  const [menus, setMenus] = useState([
    "About Us",
    "Our Products",
    "Services",
    "FAQ",
    "Contact Us",
  ]);
  const open = Boolean(anchorEl);
  
  const setPage = () => {
    props.setPage("home");
  }

  const handleMenu = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleMenuClick = () => {
    setMenuOpen(!menuOpen);
  };

  const handleLinkClick = () => {
    setMenuOpen(false);
  };

  const styles = {
    container: {
      position: "absolute",
      top: 0,
      left: 0,
      zIndex: "99",
      opacity: 0.9,
      display: "flex",
      alignItems: "center",
      background: "black",
      width: "100%",
      color: "white",
      fontFamily: "Lobster",
    },
    logo: {
      margin: "0 auto",
      cursor: "pointer",
    },
    body: {
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
      width: "100vw",
      height: "100vh",
      filter: { menuOpen } ? "blur(2px)" : null,
      transition: "filter 0.5s ease",
    },
  };

  const menuItems = menus.map((val, index) => {
    return (
      <MainMenuItem
        key={index}
        delay={`${index * 0.1}s`}
        onClick={handleLinkClick}
      >
        {val}
      </MainMenuItem>
    );
  });

  return (
    <div>
      <div style={styles.container}>
        <MenuButton open={menuOpen} onClick={handleMenuClick} color="white" />
        <div style={styles.logo} onClick={setPage}>
          Perfume Shop
        </div>
        <div>
          <IconButton
            aria-label="account of current user"
            aria-controls="menu-appbar"
            aria-haspopup="true"
            onClick={handleMenu}
            color="inherit"
          >
            <AccountCircle />
          </IconButton>
          <Menu
            id="menu-appbar"
            anchorEl={anchorEl}
            anchorOrigin={{
              vertical: "top",
              horizontal: "right",
            }}
            keepMounted
            transformOrigin={{
              vertical: "top",
              horizontal: "right",
            }}
            open={open}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Log in</MenuItem>
            <MenuItem onClick={handleClose}>Sign up</MenuItem>
          </Menu>
        </div>
      </div>
      <MainMenu open={menuOpen}>{menuItems}</MainMenu>
    </div>
  );
}
