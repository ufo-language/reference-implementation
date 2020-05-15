package main.java.data;

import java.util.Iterator;
import java.util.Objects;

import main.java.util.UFOException;

public class D_SeqReal extends D_Seq {

  // Instance variables =============================================

  private float _from, _to, _by;

  // Static inner classes ===========================================

  private static class RangeIterator implements Iterator<Obj> {

    private int _iMax, _iCur;

    private float _from, _by;

    public RangeIterator(float from, float to, float by) {
      _from = from;
      _by = by;
      _iMax = (int)((to - from) / by);
      _iCur = 0;
    }

    @Override
    public boolean hasNext() {
      return _iCur <= _iMax;
    }

    @Override
    public Obj next() {
      float next = _from + _iCur * _by;
      _iCur++;
      return D_Real.create(next);
    }
  }

  // Constructors ===================================================

  public D_SeqReal(float from, float to, float by) {
    _from = from;
    _to = to;
    _by = by;
  }

  // Instance methods ===============================================

  @Override
  public boolean boolValue() {
    return count() > 0;
  }

  @Override
  public int compareTo(Obj other) {
    if(!(other instanceof D_SeqReal))
      throw UFOException.unableToCompare(this, other);
    D_SeqReal seq = (D_SeqReal)other;
    int res = Float.compare(_from, seq._from);
    if(res != 0)
      return res;
    res = Float.compare(_to, seq._to);
    if(res != 0)
      return res;
    return Float.compare(_by, _by);
  }

  public int count() {
    int count = (int)((_to - _from) / _by + 1);
    return count;
  }

  @Override
  public boolean equals(Obj other) {
    if(this == other)
      return true;
    if(other instanceof D_SeqReal) {
      D_SeqReal r = (D_SeqReal)other;
      return _from == r._from && _to == r._to && _by == r._by;
    }
    return false;
  }

  public Obj getIndex(int index) {
    float num = index * _by + _from;
    if(num <= _to)
      return D_Real.create(num);
    return null;
  }

  public Numeric getBy() {
    return D_Real.create(_by);
  }

  public Numeric getFrom() {
    return D_Real.create(_from);
  }

  public Numeric getTo() {
    return D_Real.create(_to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_from, _to, _by);
  }

  @Override
  public Obj indexOf(Obj other) {
    int i = ((D_Integer)other).getValue();
    if(i >= _from && i <= _to) {
      i -= _from;
      if(i % _by == 0)
        return D_Real.create(i / _by);
    }
    return D_Nil.NIL;
  }

  @Override
  public Iterator<Obj> iterator() {
    return new RangeIterator(_from, _to, _by);
  }

  public void setBy(Numeric by) {
    _by = by.asInt();
  }

  @Override
  public void show(StringBuilder sb) {
    sb.append(_from).append(_TO).append(_to);
    if(_by != 1)
      sb.append(' ').append(_BY).append(' ').append(_by);
  }

  @Override
  public Obj typeConvert(String typeName) {
    Obj newObj = null;
    switch(typeName) {
      case "Array":
        newObj = D_Array.copyFrom(this, count());
        break;
      case "List":
        newObj = D_List.copyFrom(this);
        break;
      case "Queue":
        newObj = D_Queue.copyFrom(this);
        break;
      case "Set":
        newObj = D_Set.copyFrom(this);
        break;
      case "Stack":
        newObj = D_Stack.copyFrom(this);
        break;
    }
    return newObj;
  }

}
