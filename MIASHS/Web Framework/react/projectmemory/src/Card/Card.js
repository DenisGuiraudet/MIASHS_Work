import React, { Component } from 'react';
import './Card.css';
import db from '../fire.js';


class Card extends Component {


  constructor(props) {
    super(props);
    this.state = {marmotteList : []};
  }

  componentWillMount(){
    /* Create reference to messages in Firebase Database */
    db.collection("data").get().then((querySnapshot) => {
        querySnapshot.forEach((doc) => {
          this.setState({ marmotteList: this.state.marmotteList.concat(doc.data())});
          this.setState({ marmotteList: this.state.marmotteList.concat(doc.data())});
          this.setState({ marmotteList: this.state.marmotteList.sort(function() { return 0.5 - Math.random() })});
        });
    });
  }

  flipBack(){
    console.log(this.style);
  }

  render() {
    const items = this.state.marmotteList;
    const listItems = items.map((item) =>
      <div className = "card-Content">
        <div className="back">
          <img src={item.img} className="card-top" alt={item.name}></img>
          <div className = "card-footer">
            <h5>{item.name}</h5>
          </div>
        </div>
        <div className="front" onClick={(e) => this.flipBack(e)}>
          <img alt="Blizzard" src="https://cdn.vox-cdn.com/thumbor/O_m3r1bT2CtzOHY-9cwDcL4lCgQ=/0x0:1920x1080/1200x800/filters:focal(807x387:1113x693)/cdn.vox-cdn.com/uploads/chorus_image/image/53872699/battle_net.0.jpg" className="card-back"></img>
          <div className = "card-text">
            <p>{item.help}</p>
          </div>
          <div className = "card-footer">
            <h5>????</h5>
          </div>
        </div>
      </div>
    );
    return (
      <div className = "cards">{listItems}</div>
    );
  }
}

export default Card;
