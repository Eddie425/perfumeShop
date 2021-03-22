import * as React from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import TWzipcode from "react-twzipcode";
import "./order.css";

export default function AddressForm() {
  const handleChange = (data) => {
    console.log(data);
  };

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Shipping address
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={6} sm={6}>
          <TextField
            required
            id="lastName"
            name="lastName"
            label="姓"
            fullWidth
            autoComplete="family-name"
            variant="standard"
          />
        </Grid>
        <Grid item xs={6} sm={6}>
          <TextField
            required
            id="firstName"
            name="firstName"
            label="名"
            fullWidth
            autoComplete="given-name"
            variant="standard"
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="phone"
            name="phone"
            label="手機"
            fullWidth
            autoComplete="cellphone"
            variant="standard"
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="email"
            name="email"
            label="Email"
            fullWidth
            autoComplete="email"
            variant="standard"
          />
        </Grid>
        <TWzipcode
          // className="custom-select"
          css={[
            "form-control countyDist-sel",
            "form-control countyDist-sel",
            "form-control zipcode",
          ]}
          handleChangeCounty={handleChange}
          handleChangeDistrict={handleChange}
          handleChangeZipcode={handleChange}
        />
        <Grid item xs={12}>
          <TextField
            required
            id="address"
            name="address"
            label="住址"
            fullWidth
            autoComplete="shipping address"
            variant="standard"
          />
        </Grid>
        {/* <Grid item xs={12} sm={6}>
          <TextField
            required
            id="district"
            name="district"
            label="鄉鎮市區"
            fullWidth
            autoComplete="district"
            variant="standard"
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            required
            id="city"
            name="city"
            label="縣市"
            fullWidth
            autoComplete="city"
            variant="standard"
          />
        </Grid> */}
        {/* <Grid item xs={12} sm={6}>
          <TextField
            required
            id="zip"
            name="zip"
            label="Zip / Postal code"
            fullWidth
            autoComplete="shipping postal-code"
            variant="standard"
          />
        </Grid> */}
        {/* <Grid item xs={12} sm={6}>
          <TextField
            required
            id="country"
            name="country"
            label="Country"
            fullWidth
            autoComplete="shipping country"
            variant="standard"
          />
        </Grid> */}
        <Grid item xs={12}>
          <FormControlLabel
            control={
              <Checkbox color="secondary" name="saveAddress" value="yes" />
            }
            label="Use this address for payment details"
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
